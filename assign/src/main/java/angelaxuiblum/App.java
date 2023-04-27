package angelaxuiblum;

/**
 * @file junior.java
 * @author Angela Xu (as2xu@uwaterloo.ca)
 * @brief function for the junior problem of iBlum
 * @version 0.1
 * @date 2023-03-30
 * 
 * @copyright Copyright (c) 2023
 * 
 */

public class App 
{
    /**
     * printMultiples(s) prints the corresponding string result for each number s
     * @param int s
     * @return string result
     */

    public String printMultiples(int s) {
        String result = "";
        boolean mult = false;
        if (s % 3 == 0 && s % 5 == 0 && s % 7 == 0) {
            result += "iBlüm";
            return result;
        }
        if (s % 3 == 0) {
            result += "Devhaus";
            mult = true;
        }
        if (s % 5 == 0) {
            if (mult) {
                result += " ";
            }
            result += "Learning";
            mult = true;
        }
        if (s % 7 == 0) {
            if (mult) {
                result += " ";
            }
            result += "Model";
            mult = true;
        }
        if (!mult) {
            result += s;
        }
        return result;
    }

    /**
     * main class to execute function from 1 to 105 onto console
     * @param args
     */
    public static void main( String[] args )
    {
        App app = new App();
        for (int i = 1; i <= 105; i++) {
            System.out.print(app.printMultiples(i) + " ");
        }
    }
}
