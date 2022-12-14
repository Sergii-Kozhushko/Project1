/**
 * Homework4.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Dec-2022 15:44
 */

package edu.javacourse.g5152;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    // 1. � ������ �������� �������� � 1 �� 20. �� ������ � 21 �� 48. � ������� � 49 �� 90.
    // ������������ ������ ����� ��������.
    // ��������� ������ ������� � ����� �������� ��������� ������ ��������.
    public static void flatNum() {
        Scanner scanner = new Scanner(System.in);
        int flatNumber;
        boolean doAsk = true;
        do {
            System.out.print("������� ����� �������� (0 - �����): ");
            flatNumber = scanner.nextInt();
            if (flatNumber >= 1 && flatNumber <= 20) {
                System.out.println("�������� ��������� � ������ ��������");
            }
            if (flatNumber >= 21 && flatNumber <= 48) {
                System.out.println("�������� ��������� �� ������ ��������");
            }
            if (flatNumber >= 49 && flatNumber <= 90) {
                System.out.println("�������� ��������� � ������ ��������");
            }
            if (flatNumber == 0) doAsk = false;

        } while (doAsk);
    }

    // 2. ���������� num ����� ��������� 4 ��������: 1, 2, 3 ��� 4.
    // ���� ��� ����� �������� '1', �� � ���������� result ������� '����',
    // ���� ����� �������� '2' � '�����' � ��� �����.
    // ������ ������ ����� switch-case.
    public static void switchExample() {
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean doAsk = true;
        do {
            System.out.print("������� ����� �� 0 �� 3 (4 - �����): ");
            num = scanner.nextInt();
            String result = switch (num) {
                case 0 -> "����";
                case 1 -> "�����";
                case 2 -> "����";
                case 3 -> "�����";
                default -> "";
            };
            System.out.println("���������: " + result);
            if (num == 4) doAsk = false;
        } while (doAsk);
    }

    // 3. � ���������� month ����� �����-�� ����� �� ��������� �� 1 �� 12.
    // ���������� � ����� ���� ���� �������� ���� ����� (����, ����, �����, �����).
    public static void determineSeason() {
        int month;
        String season = "", answer = "";
        boolean doNextMonth = true;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            month = random.nextInt(12);
            if (month == 12 || month <= 3) {
                season = "����";
            }
            if (month >= 9 && month <= 11) {
                season = "�����";
            }
            if (month >= 6 && month <= 8) {
                season = "����";
            }
            if (month >= 3 && month <= 5) {
                season = "�����";
            }
            System.out.printf("����� �%s, ����� %s%n", month, season);
            System.out.print("��� ���? y/n ");
            answer = scanner.nextLine();
            doNextMonth = answer.equals("y");
        } while (doNextMonth);
    }

    // Second level. ������� ����� ����� � �������.
    // ������������ ������ ����� �� 1 �� 9999 (����� ������ � ���������).
    // ���������� ������� �� ����� ������� ��������� ����� �
    // � ����� �������� �������� ������ � ���������� ����������

    // ����� ���������� ������ "������-��" � ���������� ����������
    public static String getCurrencyStringEnd(int num) {
        int num11 = num % 100;// ��������� ��� �����
        int n4 = num % 10;// ��������� �����
        String result;

        if (num11 != 11 && num11 != 12 & num11 != 13 && num11 != 14) {
            result = switch (n4) {
                case 1 -> "������";
                case 2 -> "�������";
                case 3 -> "�������";
                case 4 -> "�������";
                case 5 -> "��������";
                case 6 -> "��������";
                case 7 -> "��������";
                case 8 -> "��������";
                case 9 -> "��������";
                default -> "";
            };
        }
        else {
            result = "��������";
        }
        return result;
    }

    // ����� ��������� ����� � ������ ��������
    public static String convertNumToWord(int currencyNum) {
        String result, endDollar = "";
        int n1, n2, n3, n4;
        n1 = currencyNum / 1000;
        result = switch (n1) {
            case 1 -> "���� ������";
            case 2 -> "��� ������";
            case 3 -> "��� ������";
            case 4 -> "������ ������";
            case 5 -> "���� �����";
            case 6 -> "����� �����";
            case 7 -> "���� �����";
            case 8 -> "������ �����";
            case 9 -> "������ �����";
            default -> "";
        };
        if (n1 > 0) result += " ";
        n2 = (currencyNum - (currencyNum / 1000) * 1000) / 100;
        result += switch (n2) {
            case 1 -> "���";
            case 2 -> "������";
            case 3 -> "������";
            case 4 -> "��������";
            case 5 -> "�������";
            case 6 -> "��������";
            case 7 -> "�������";
            case 8 -> "���������";
            case 9 -> "���������";
            default -> "";
        };
        if (n2 > 0) result += " ";

        n3 = ((currencyNum % 100) - (currencyNum % 10)) / 10;

        result += switch (n3) {
            case 2 -> "��������";
            case 3 -> "��������";
            case 4 -> "�����";
            case 5 -> "���������";
            case 6 -> "����������";
            case 7 -> "���������";
            case 8 -> "�����������";
            case 9 -> "���������";
            default -> "";
        };
        if (n3 == 1) {
            n4 = currencyNum % 100;
            result += switch (n4) {
                case 10 -> "������";
                case 11 -> "�����������";
                case 12 -> "����������";
                case 13 -> "����������";
                case 14 -> "������������";
                case 15 -> "����������";
                case 16 -> "�����������";
                case 17 -> "�����������";
                case 18 -> "������������";
                case 19 -> "�������������";
                default -> "";
            };
        } else {
            if (n3 > 0) result += " ";
            n4 = currencyNum % 10;
            result += switch (n4) {
                case 1 -> "����";
                case 2 -> "���";
                case 3 -> "���";
                case 4 -> "������";
                case 5 -> "����";
                case 6 -> "�����";
                case 7 -> "����";
                case 8 -> "������";
                case 9 -> "������";
                default -> "";
            };
        }
        result += " " + getCurrencyStringEnd(currencyNum);


        return result;
    }

    public static void bankomat() {
        Scanner scanner = new Scanner(System.in);
        int sumCurrency;
        System.out.print("�������� ����� �� 1 �� 9999: ");
        sumCurrency = scanner.nextInt();
        System.out.println("���� ����� �������: " + convertNumToWord(sumCurrency));
    }

    public static void main(String[] args) {
        //flatNum();
        //switchExample();
        //determineSeason();
        bankomat();

    }

}
