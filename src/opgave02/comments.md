Rigtigt fint med playAgain metoden. I laver dog et nyr Scanner objekt hver gang metoden bliver kaldt, hvilket kan give problemer hvis I ikke får lukket 
den igen. Brug

    input.close();

for at lukke forbindelse til System.in

---

I linje 69

    while (answer == "")

bør I bruge String klassen metoder til at sammenligning. 

    while (answer.equals(""))

eller 

    while (answer.isEmpty())