package com.bell.Mikhail;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondApiTest
{
    public static void main(String[] args)
    {
        System.out.println( executePost("https://suggestions.dadata.ru/suggestions/api/4_1/rs/detectAddressByIp?ip=46.226.227.20"));

    }
    public static String executePost(String targetURL)
    {
        HttpURLConnection connection = null;
        //В Java предоставляется подкласс HttpURLConnection, производный от класса URLConnection и поддерживающий соединения по сетевому протоколу НТТР.
        // Чтобы получить объект класса HttpURLConnection, следует вызвать метод openConnection() для объекта типа URL

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection(); //Создаём переменную приведённого типа (HttpURLConnection) и вызываем соответствующим методом
            //Метод GET отправляет скрипту всю собранную информацию формы как часть URL. Передача вместе с адресом, объём 255, кэшируется
            //Метод POST передает данные таким образом, что пользователь сайта уже не видит передаваемые скрипту данные: Стандартный поток, объём 8 КБ, не кэшируется
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty( "Authorization", "Token 3a7a25d6d5f2b2d5a9729c1f6321a99f32860dd0");



            connection.setUseCaches(false);
            connection.setDoOutput(true);



            //Отправляемые параметры
            //Класс DataOutputStream представляет поток вывода и предназначен для записи данных примитивных типов, таких, как int, double и т.д.
            // Для записи каждого из примитивных типов предназначен свой метод
            //DataOutputStream wr = new DataOutputStream(
            //       connection.getOutputStream());
            //%s- вместо будет вставлено urlParameters
            //wr.writeBytes(String.format( "{(\"ip\"=\"%s\"}"));
            //wr.close();

            //Базовый класс InputStream представляет классы, которые получают данные из различных источников:
            //массив байтов
            //строка (String)
            //файл
            //канал (pipe): данные помещаются с одного конца и извлекаются с другого
            //последовательность различных потоков, которые можно объединить в одном потоке
            //другие источники (например, подключение к интернету)
            //InputStream - поток, BufferedReader - буферизирует поток, InputStreamReader - считывает поток
            //
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer response = new StringBuffer(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
