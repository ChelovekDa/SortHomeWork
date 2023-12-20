package com.example.sorthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    // поля
    // стихотворение для анализа
    private String poem = "У лукоморья дуб зелёный;\nЗлатая цепь на дубе том:\nИ днём и ночью кот учёный\nВсё ходит по цепи кругом;\n" +
            "Идёт направо — песнь заводит,\nНалево — сказку говорит.\nТам чудеса: там леший бродит,\nРусалка на ветвях сидит;\n" +
            "Там на неведомых дорожках\nСледы невиданных зверей;\nИзбушка там на курьих ножках\nСтоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\nТам о заре прихлынут волны\nНа брег песчаный и пустой,\nИ тридцать витязей прекрасных\n" +
            "Чредой из вод выходят ясных,\nИ с ними дядька их морской;\nТам королевич мимоходом\nПленяет грозного царя;\n" +
            "Там в облаках перед народом\nЧерез леса, через моря\nКолдун несёт богатыря;\nВ темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\nТам ступа с Бабою Ягой\nИдёт, бредёт сама собой,\nТам царь Кащей над златом чахнет;\n" +
            "Там русский дух… там Русью пахнет!\nИ там я был, и мёд я пил;\nУ моря видел дуб зелёный;\nПод ним сидел, и кот учёный\n" +
            "Свои мне сказки говорил.";
    private String[] poemArray; // массив для слов стихотворения

    private TextView output; // поле вывода результата на экран смартфона
    private TextView sorted;

    private ArrayList<String> newList = new ArrayList<>();

    private boolean deleteRepeatLetters = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialization(deleteRepeatLetters);

    }

    private void Initialization(boolean deleteRepeatLetters) {
        output = findViewById(R.id.output);
        sorted = findViewById(R.id.sorted);

        poemArray = stringToArray(poem);
        output.setText(maxWord(poemArray));
        output.append(minWord(poemArray));
        output.append(numberOfLetters(poemArray));

        Collections.sort(converter(poemArray));
        System.out.println(newList);

        String text = "";
        for (int i = 0; i < newList.toArray().length; i++) {
            text = text + newList.toArray()[i].toString();
        }
        System.out.println(text);
        sorted.setText(text);
    }

    private ArrayList<String> converter(String[] oldList) {
        for (int i = 0; i < oldList.length-1; i++) {
            newList.add(oldList[i] + "\n");
        }
        return newList;
    }

//    private ArrayList<String> deleteLetters(ArrayList<String> object) {
//        for (int i = 0; i < object.toArray().length; i++) {
//            String letter = object.toArray()[i].toString();
//            for (int j = 0; j < object.toArray().length; j++) {
//                if (object.toArray()[j].toString() == letter) {
//                    object.remove(j);
//                }
//                else continue;
//            }
//        }
//
//        return object;
//    }

    // метод поиска самого длинного слова
    private String maxWord(String[] poemArray) {

        String worldResult = "Самое длинное слово \"";
        int maxLength = 0; // максимальная длина слова
        int indexMaxLength = 0; // индекс слова с максимальной длинной

        for (int i = 0; i < poemArray.length; i++) {
            if(poemArray[i].length() > maxLength) { // если длина слова больше предыдущего максимального значения, то
                maxLength = poemArray[i].length(); // присваиваем новую максимальную длину
                indexMaxLength = i; // записываем индекс найденного слова
            }
        }

        return worldResult + poemArray[indexMaxLength] + "\" длинной " + maxLength + " букв(а)\n";
    }

    // метод поиска самого короткого слова
    private String minWord(String[] poemArray) {

        String worldResult = "Самое короткое слово \"";
        int minLength = Integer.MAX_VALUE; // минимальная длина слова
        int indexMinLength = 0; // индекс слова с минимальной длинной

        for (int i = 0; i < poemArray.length; i++) {
            if(poemArray[i].length() < minLength) { // если длина слова меньше предыдущего минимального значения, то
                minLength = poemArray[i].length(); // присваиваем новую минимальную длину
                indexMinLength = i; // записываем индекс найденного слова
            }
        }

        return worldResult + poemArray[indexMinLength] + "\" длинной " + minLength + " букв(а)\n";
    }

    // метод определения количества букв в стихотворении
    private String numberOfLetters(String[] poemArray) {

        String worldResult = "В стихотворении ";
        int count = 0; // счётчик количества букв

        for (int i = 0; i < poemArray.length; i++) {
            count = count + poemArray.length;
        }

        return worldResult + count + " букв(а)\n";
    }

    // метод конвертирования строки в массив
    private String[] stringToArray(String text) {

        String textMod = text.replaceAll("[^А-Яа-яёЁ]", " ").trim(); // замена всех символов кроме букв на пробелы и удаление начальных и конечных пробелов
        String[] textArray = textMod.split("\\s+"); // деление строки по всем пробелам (от 1 до большего количества пробелов)

        return textArray;
    }
}