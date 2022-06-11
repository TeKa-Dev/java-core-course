package module_3_base_of_OOP;

// Задача 3.4.8

/*
Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals()
сравнивал экземпляры ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
*/

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber() {
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {                                      // если ссылки равны, то это один и тот же объект
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) { // если null или они разных классов то не равны
            return false;
        }
        ComplexNumber cn = (ComplexNumber) obj;                  // даункаст к этому классу

        // сравниваем на рвенство переменные обоих обьектов через метод класса обёртки
        return Double.compare(this.re, cn.re) == 0 && Double.compare(this.im, cn.im) == 0;
    }

    @Override
    public int hashCode() {

        return (int)( 31 * im + re);
    }

}
// (int)(bits ^ (bits >>> 32));