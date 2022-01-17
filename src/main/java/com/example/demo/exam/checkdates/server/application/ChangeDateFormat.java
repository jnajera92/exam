package com.example.demo.exam.checkdates.server.application;

import com.example.demo.exam.checkdates.server.domain.DateClient;
import com.example.demo.exam.checkdates.server.domain.DateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@Component
public class ChangeDateFormat {

    @Autowired
    DateClient dateClient;

    public Flux<String> formatDate(){
        Flux<String> event = Flux.range(1,10).map(
                x->{
                    try{
                        return dateZone(dateClient.getDate().toFuture().get());
                    }catch (Exception e){
                        return "Ocurrio un error al obtener la respuesta del servicio";
                    }
                }
        );
        return event;
    }

    private String dateZone(DateDto dateDto){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(dateDto.getDate());
            stringBuilder.append(dateDto.getTime());

            Date secons = new Date(Long.parseLong(dateDto.getMilliseconds_since_epoch())*1000);
            Date sdfMex = new SimpleDateFormat("dd-MM-YYYYHH:mm:ss aa").parse(stringBuilder.toString());

            Calendar c = new GregorianCalendar(TimeZone.getTimeZone("japan"));

            c.setTime(sdfMex);
            c.add(Calendar.SECOND, secons.getSeconds());

            SimpleDateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            converter.setTimeZone(TimeZone.getTimeZone("UTC"));
            String timeZone = converter.format(c.getTime());
            return timeZone;
        }catch (Exception e){
            return  "Ocurrio un proble en el formato de fechas: "+e;
        }
    }


}
