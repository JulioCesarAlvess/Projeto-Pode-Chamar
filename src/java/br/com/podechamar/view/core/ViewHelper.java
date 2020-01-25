
package br.com.podechamar.view.core;

import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author Julio Cesar Alves
 */
public abstract class ViewHelper implements I_ViewHelper{
    
        public Object preencher(I_DadosVisao visao, Class classeAlvo) {

        try {
            Object objeto = classeAlvo.newInstance();

            Field[] atributos = classeAlvo.getDeclaredFields();
            for (Field atributo : atributos) {
                // Procura por um atributo que tenha o nome do parâmetro ou tenha pontos (.) em seu nome,
                // o que pode indicar um objeto dentro de outro.
                // Por exemplo: endereco.logradouro.
                if (visao.existe(atributo.getName())) {

                    atributo.setAccessible(true);
                    if ("int".equals(atributo.getType().getName()) || atributo.getType() == Integer.class) {
                        atributo.set(objeto, visao.getInt(atributo.getName()));
                    } else if ("double".equals(atributo.getType().getName()) || atributo.getType() == Double.class) {
                        atributo.set(objeto, visao.getDouble(atributo.getName()));
                    } else if (atributo.getType() == String.class) {
                        atributo.set(objeto, visao.get(atributo.getName()));
                    }else if (atributo.getType() == Date.class) {
                        atributo.set(objeto, visao.getDate(atributo.getName()));
                    } // ...
                    else {
                        atributo.set(objeto, preencher(visao, atributo.getType(), atributo.getName() + "."));
                    }

                } else {
                }
            }

            return objeto;

        } catch (InstantiationException | IllegalAccessException ex) {
            return null;
        }

    }
        
        
        
        
    public Object preencher(I_DadosVisao visao, Class classeAlvo, String prefixo) {

        try {
            Object objeto = classeAlvo.newInstance();

            Field[] atributos = classeAlvo.getDeclaredFields();
            for (Field atributo : atributos) {
                // Procura por um atributo que tenha o nome do parâmetro ou tenha pontos (.) em seu nome,
                // o que pode indicar um objeto dentro de outro.
                // Por exemplo: endereco.logradouro.
                if (visao.existe(prefixo + atributo.getName())) {

                    atributo.setAccessible(true);
                    if ("int".equals(atributo.getType().getName()) || atributo.getType() == Integer.class) {
                        atributo.set(objeto, visao.getInt(prefixo + atributo.getName()));
                    } else if ("double".equals(atributo.getType().getName()) || atributo.getType() == Double.class) {
                        atributo.set(objeto, visao.getDouble(prefixo + atributo.getName()));
                    } else if (atributo.getType() == String.class) {
                        atributo.set(objeto, visao.get(prefixo + atributo.getName()));
                    } // ...
                    else {
                        atributo.set(objeto, preencher(visao, atributo.getType()));
                    }

                } else {
                }
            }

            return objeto;

        } catch (InstantiationException | IllegalAccessException ex) {
            return null;
        }

    }    
}
