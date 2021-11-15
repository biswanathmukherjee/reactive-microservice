package com.ibm.learn.reactive.microservice.utils;

import com.ibm.learn.reactive.microservice.entities.Cricketer;
import com.ibm.learn.reactive.microservice.models.CricketerDTO;
import org.springframework.beans.BeanUtils;

public class TransformationUtils {
    public static CricketerDTO entityToDTO(Cricketer cricketer){
        CricketerDTO cricketerDTO = new CricketerDTO();
        BeanUtils.copyProperties(cricketer, cricketerDTO);
        return cricketerDTO;
    }

    public static Cricketer dtoToEntity(CricketerDTO cricketerDTO){
        Cricketer cricketer = new Cricketer();
        BeanUtils.copyProperties(cricketerDTO, cricketer);
        return cricketer;
    }


}
