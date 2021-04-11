import java.util.Scanner;
class Sotrudniki{
    String fam, im, otch;
    int vozrast, razmer;
}
public class people {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.println("Введите количество сотрудников => ");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера после ввода числа
        Sotrudniki[] sotr = new Sotrudniki[kol]; // получена ссылка на массив сотрудников
        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new Sotrudniki(); // получена ссылка на i-тый элемент
            // Присвоение значений полям
            System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введите его возраст => ");
            sotr[i].vozrast = sc.nextInt();

            System.out.print("Введите его размер одежды => ");
            sotr[i].razmer = sc.nextInt();
            sc.nextLine(); //очистка буфера
        } // end for
        // Вывод информации о сотрудниках
        System.out.println("\n Сотрудники фирмы: \n фам \t имя \t отч \t возраст \t размер одежды");
        for (Sotrudniki s : sotr) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.otch + "\t " + s.vozrast + "\t\t" + s.razmer + "\n");
        }
// человек с самым большим размером одежды
        int nommax = 0;
        double max = sotr[nommax].razmer;
        for (Sotrudniki str : sotr)
            System.out.println("" + str.fam + "\t" + str.im + "\t" + str.otch + "\t" + str.razmer + " лет");
        for (int i = 0; i < sotr.length; i++)
            if (sotr[i].razmer > max) {
                max = sotr[i].razmer;
                nommax = i;
            }

        System.out.println("\nЧеловек с самым большим размером одежды :");
        System.out.println("" + sotr[nommax].fam + "\t" + sotr[nommax].im + "\t" + sotr[nommax].otch + "\t" + sotr[nommax].razmer + "");
        // СРЕДНИЙ РАЗМЕР ОДЕЖДЫ ДЛЯ ЛЮДЕЙ СТАРШЕ 40 ЛЕТ
        double s=0; // суммарный размер
            for (int i = 0; i < sotr.length; i++)
            if (sotr[i].vozrast>40) {
                s += sotr[i].razmer;
                double sr = s / sotr.length;
                ; // средний размер
                System.out.println("\nСРЕДНИЙ РАЗМЕР ОДЕЖДЫ ДЛЯ ЛЮДЕЙ СВЫШЕ 40 ЛЕТ "+ s/sotr.length+"");
            }
        for (int i=0; i< sotr.length-1; i++)
            for (int j = 0; j < sotr.length-1-i; j++)
                if (sotr[j].razmer>sotr[j+1].razmer){
                    Sotrudniki rab=sotr[j]; // rab – рабочая переменная для перестановки
                    sotr[j]=sotr[j+1];
                    sotr[j+1]=rab;
                }
        System.out.println("\nОтсортированный список по размеру:");//
        for (int i = 0; i < sotr.length; i++) {
            System.out.println(sotr[i].razmer);
        }

        sc.nextLine(); // очистка буфера
        System.out.println("Введите фамилию=> ");
        String fam=sc.nextLine();
        int nom=-1; // -1 – страна с искомым названием отсутствует

        for (int i = 0; i < sotr.length; i++)
            if (fam.equalsIgnoreCase(sotr[i].fam))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такая фамилия есть в списке. Это " + sotr[nommax].fam + "\t" + sotr[nommax].im + "\t" + sotr[nommax].otch + "\t" + sotr[nommax].razmer + "");
        }else System.out.println("Такой фамилии нет в списке");
    }
    }

