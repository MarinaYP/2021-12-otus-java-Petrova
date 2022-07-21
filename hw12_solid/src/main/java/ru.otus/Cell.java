package ru.otus;

//класс Ячейка банкомата
    class Cell {
        private int count; //количество купюр

        protected Cell() { //какая область видимости конструктора?
            this.count = 0;
        }
        protected Cell(int count) {this.count = count;}

        protected void putMoney(int count) {
            this.count += count;
        }

        protected void getMoney(int count){
            this.count -= count;
        }

        protected int getCount() {
            return this.count;
        }
    }