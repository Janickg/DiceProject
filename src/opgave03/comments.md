I stedet for at være en attribut bør

    gameOver

være en lokal variabel i playPigs() metoden, da den ikke bliver brugt andre steder.

---

Alle de steder hvor I skifter spiller kunne I have lavet en metode

    public void switchPlayer() {
        isPlayerOne = !isPlayerOne;
    }

---

Rigtig fin løsning. 

