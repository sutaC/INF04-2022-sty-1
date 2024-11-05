#!/bin/python

class SortOperator:
    def __init__(self) -> None:
        self.array = list[int]()

    # /********************************************************
    # * nazwa funkcji: sortArray
    # * parametry wejściowe: nic
    # * wartość zwracana: nic
    # * autor: XYZ
    # * ****************************************************/ 
    def sortArray(self) -> None:
        for i in range(len(self.array) - 1):
            maxI = self.__findMax(i)
            tmp = self.array[maxI]
            self.array[maxI] = self.array[i]
            self.array[i] = tmp

    # /********************************************************
    # * nazwa funkcji: __findMax
    # * parametry wejściowe: start - (int) miejsce startu szukania w tablicy
    # * wartość zwracana: (int) - indeks maksymalnej wartości tablicy w zakresie
    # * autor: XYZ
    # * ****************************************************/ 
    def __findMax(self, start: int = 0) -> int:
        maxI = start
        for i in range(start + 1, len(self.array)):
            if self.array[maxI] < self.array[i]:
                maxI = i
        return maxI

    def readValues(self) -> None:
        self.array.clear()
        print("Podaj 10 wartości tablicy:")
        for i in range(10):
            num = None
            while True:
                num = input(f"{i+1}> ")
                try:
                    num = int(num)
                except:
                    continue
                break
            self.array.append(num)

    def displayArray(self) -> None:
        for num in self.array:
            print(num, end=", ")
        print("")        

# Start
operator = SortOperator()
print("Program sortujący wczytaną tablicę")
operator.readValues()
operator.sortArray()
print("Elementy tablicy po posortowaniu: ")
operator.displayArray()
