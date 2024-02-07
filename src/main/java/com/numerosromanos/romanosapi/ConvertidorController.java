package com.numerosromanos.romanosapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertir")
public class ConvertidorController {

    @GetMapping("/{numero}")
    public String convertir(@PathVariable Integer numero){
        String[] romanos={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] enteros={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Integer originalNumero=numero;

        StringBuilder result=new StringBuilder();

        // 990
        // i -> 0, 1
        // result -> L
        // numero -> 40
        if(numero<=0 || numero>3999){
            return "Numero no valido, porfavor ingrese un numero mayor a 0 y menor o igual a 3999";
        }

        int i=0;

        while (numero>0){
            if(numero>=enteros[i]){
                result.append(romanos[i]);
                numero-=enteros[i];
            }else{
                i++;
            }
        }

        return "El numero " +originalNumero + " en formato romano es: "+ result.toString();
    }
}
