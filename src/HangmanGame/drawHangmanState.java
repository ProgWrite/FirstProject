package HangmanGame;

public class drawHangmanState {
    public static void drawMan(int hangnamStatus){
        switch(hangnamStatus){
            case 0:
                System.out.println("      __________");
                System.out.println("       |       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("    ___|___");
                break;

            case 1:
                System.out.println("      __________");
                System.out.println("       |       |");
                System.out.println("       |       O");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("    ___|___");
                break;

            case 2:
                System.out.println("      __________");
                System.out.println("       |       |");
                System.out.println("       |       O");
                System.out.println("       |       |");
                System.out.println("       |");
                System.out.println("    ___|___");
                break;

            case 3:
                System.out.println("      __________");
                System.out.println("       |       |");
                System.out.println("       |       O");
                System.out.println("       |      /|");
                System.out.println("       |");
                System.out.println("    ___|___");
                break;


            case 4:
                System.out.println("      _________");
                System.out.println("       |      |");
                System.out.println("       |      O");
                System.out.println("       |     /|\\");
                System.out.println("       |      ");
                System.out.println("    ___|___");
                break;


            case 5:
                System.out.println("      _________");
                System.out.println("       |      |");
                System.out.println("       |      O");
                System.out.println("       |     /|\\");
                System.out.println("       |     /");
                System.out.println("    ___|___");
                break;

            case 6:
                System.out.println("      _________");
                System.out.println("       |      |");
                System.out.println("       |      O");
                System.out.println("       |     /|\\");
                System.out.println("       |     / \\");
                System.out.println("    ___|___");
                break;
        }
    }
}
