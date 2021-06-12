# Automated_test_for_xtool.ru

Автоматизированное тестирование для сайта: https://xtool.ru/



## UseCase-диаграмму с прецедентами использования тестируемого сайта

![alt text](https://github.com/progML/Automated_test_for_xtool.ru/blob/master/UseCase.png)


### CheckList тестового покрытия
1)	Авторизация
+ Успешная авторизация
+ Неудачная авторизация
2)	Траст сайта
+	Просмотр основных метрик
+ Видимость в Яндекс/Google
+	Whios данные
3)	Мои проверки
+	Хосты
+	Внутренние
4)	Seo аудит сайта
+	Обратные ссылки
+	Проверка валидности IP


### Описание набора тестовых сценариев.
1)	Авторизация
  +	Успешная авторизация
    1)	Зайти на сайт
    2)	Ввести Почту и пароль
    3)	Нажать кнопку Войти
  +	Неудачная авторизация
    1)	Зайти на сайт
    2)	Ввести неверные почту и пароль
    3)	Нажать кнопку Войти

![alt text](https://github.com/progML/Automated_test_for_xtool.ru/blob/master/result/test1.gif)


2)	Траст сайта
  +	Просмотр основных метрик
    1) Авторизоваться 
    2) Ввести в поле URL исследуемого сайта 
    3) Нажать кнопку “Проверить”   
  +	Видимость в Яндекс/Google
    1) Авторизоваться 
    2) Нажать кнопку “Видимость в Яндексе” 
    3) Выбрать страну, тип выдачи и город для проверки
  +	Whois данные 
    1) Авторизоваться 
    2) Нажать кнопку “Whios данные” 
    3) Проверить доменное имя


3)	Мои проверки
  +	Зайти на сайт
  +	Авторизоваться 
  +	Нажать на кнопку хосты
  +	Нажать на кнопку внутренние

4)	Seo аудит сайта
  +	Зайти на сайт
  +	Авторизоваться 
  +	Нажать кнопку “Обратные ссылки”
  +	Ввести URL в поле
  +	Нажать кнопку найти.
