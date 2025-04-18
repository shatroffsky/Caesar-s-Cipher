# Проєкт: Шифр Цезаря
Цей проєкт — реалізація модифікованого шифру Цезаря, одного з найпростіших і найвідоміших методів шифрування. 
Він зсуває кожну літеру повідомлення на фіксовану кількість позицій у алфавіті.

### Проєкт ідеально підходить для:
- ознайомлення з базовими принципами криптографії;
- практики роботи з рядками та алгоритмами;
- вивчення історії шифрування.

### Чому він крутий?
- Простий у використанні — просто обери необхідний текст і обери зсув.
- Працює як для шифрування, так і для дешифрування.
- Присутній інтерфейс для зручнішого використання.

## Технології
Цей проєкт реалізований на Java з використанням стандартної бібліотеки та 
GUI-компонентів для створення інтерактивного інтерфейсу.

### Використано:
* Java AWT та Swing — для побудови графічного інтерфейсу користувача
* java.nio.file та java.io — для роботи з файлами: зчитування, збереження та обробка тексту.
* Collections API (ArrayList, Arrays) — для зручної роботи з даними.

#### Завдяки поєднанню цих технологій, застосунок:
1. має зручний інтерфейс для шифрування/дешифрування тексту;
2. підтримує завантаження/збереження файлів;
3. працює швидко й ефективно без сторонніх залежностей.

## Що вийшло зробити.
1. Підтримку двох мов: Англійської та Української.
2. Використання символів.
3. Автоматичне розпізнавання мови у файлі із доступних мов.
4. Підтримка великих та малих літер.
5. Можливість запускати програму через аргументи, консольне GUI або повноцінний простенький інтерфейс.
6. Опція BruteForce яка дозволяє спробувати перебрати всі ключі для розшифрування немаючи ключа, та збереження всіх результатів в окрему папку.
7. Зібрати збірку програми у .jar файлі. 

## Що НЕ вийшло зробити.
1. BruteForce не знаходить один єдиний ключ а лише перебирає повністю всі, що займає додатковий час для перевірки усіх розшифрованих файлів та знаходження вірного.
2. Не реалізована функція BruteForce через частотний аналіз.

## Структура проєкту
```plaintext
📦 src
├── 📄 Main.java
├── 📁 CaesarCipher
│   ├── 📄 BrudeForce.java
│   ├── 📄 CaesarCipher.java
│   └── 📄 ConstantsForAlphabet.java
├── 📁 FileReaderOrWriter
│   ├── 📄 FileBrudeForce.java
│   ├── 📄 FileToDecrypt.java
│   └── 📄 FileToEncrypt.java
├── 📁 META-INF
│   └── 📄 MANIFEST.MF
└── 📁 RunProgram
    ├── 📄 FrontEnd.java
    ├── 📄 GuiInConsole.java
    └── 📄 Runner.java
```

## Автор
[@shatroffsky](https://github.com/shatroffsky)
