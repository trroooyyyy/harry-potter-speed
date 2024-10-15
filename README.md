Основні зміни:
- HashMap для підрахунку частоти: Замість двох вкладених циклів ми використовуємо хеш-таблицю (HashMap), яка дозволяє швидко збільшувати лічильник кожного унікального слова.

- Стрімінг та сортування: Використовуємо методи стрімінгу, щоб сортувати слова за частотою і потім вивести найбільш часті. Це робить код більш лаконічним і дозволяє уникнути додаткових операцій.

- Зменшення часу на пошук унікальних слів: Ми більше не використовуємо рядковий пошук через метод contains(), що значно пришвидшує роботу з великими масивами слів.

- Уникнення непотрібної конкатенації рядків: Конкатенація рядків у циклі через += призводить до створення великої кількості об'єктів у пам'яті. Замість цього краще використовувати StringBuilder.
