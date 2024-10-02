I har jeres tjek for om rullet er højere end tidligere rul

            if (sumOfTwoDices > biggestThrow) {
                int largestSumOfTwoDices = faces[0] + faces[1];
                biggestThrow = largestSumOfTwoDices;
            }

inden for en for løkke, så I laver det samme tjek to gange.

---

Selve for-løkken 

    for (int index = 0; index < faces.length; index++) {
        amountFace[faces[index] - 1]++;
    }

ville jeg erstatte med

    amountFace[faces[0] - 1]++;
    amountFace[faces[1] - 1]++;

når der ikke er mere end to terninger.

---

    