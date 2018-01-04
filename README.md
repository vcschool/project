# Mokymosi įstaigos valdymo sistema (pirmas etapas)
# (REIKALAVIMAI NE GALUTINIAI IR GALI KEISTIS)

Projekto reikalavimai:

  Projekto kodas saugomas github'e
  Projektui valdyti naudojamas maven 
  Visa programos veikimo metu sukurta infrmacija saugoma failuose
  Programos logika padengta unit testais
  Vartotojo sąsajai naudojama konsolė

Funkcionalumo reikalavimai:

  * Pirmą kartą paleidus programą turi egzistuoti vartotojas admin su slaptažodžiu admin, kuris turėtų admin rolę ir galėtų atlikti viskas operacijas programoje.

  * Prie sistemos galima prisijungti suvedus username ir password.

  * Sistemoje naujus vartotojus gali užsiregistruoti tik vartotojai su admin role
```
  įvedę:
    firstName, secondName, password
  pasirinkę:
    rolę iš admin, lecturer, student
```

  * Vartotojai turintys rolę lecturer arba student gali keisti, pridėti informaciją apie save
```
    firstName
    lastName
    personalNumber
    dateOfBirth
    email
    mobileNumber
    gender
    address
    runningCourses (kursai, kuriuos veda)

```
  * Vartotojai turintys rolę admin gali
    * pridėti course
    ```
      code
      tittle
      desciption
      startDate
      credit
      lecturerCode
      ```
    * pamatyti visų studentų sąrašą
    * pamatyti visų kursų sąrašą

   * Vartotojai su student role gali:
    * užsiregistruoti į kursą kai:
      * kurso startDate yra ankstenė už dabatinę
      * bendra užseregistuotų kursų kreditų suma mažesnė us 12

   * Vartotojai su lecturer role gali:
    * matyti jam priskirtus kursus
    * matyti į kursą užsiregistravusius studentus


