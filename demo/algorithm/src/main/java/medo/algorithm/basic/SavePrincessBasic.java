package medo.algorithm.basic;

import medo.algorithm.SavePrincess;

public class SavePrincessBasic implements SavePrincess {

    private static String S = "S";
    private static String R = "R";
    private static String L = "L";

    @Override
    public String run(String command) {
        // 判断是 x 还是 y ,是 加还是减
        // x, y
        String[] commands = command.split("");
        int[] coord = excute(commands, 0, 0, "N");
        if (coord[0] == 0 && coord[1] == 0) {
            return "no";
        } else {
            return "yes";
        }
    }

    private int[] excute(String[] commands, int offsetX, int offsetY, String direction) {
        // N E W S, N S - y, E W - x,
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (S.equals(command)) {
                if ("N".equals(direction)) {
                    offsetY++;
                }
                if ("S".equals(direction)) {
                    offsetY--;
                }
                if ("E".equals(direction)) {
                    offsetX++;
                }
                if ("W".equals(direction)) {
                    offsetX--;
                }
            } else {
                direction = getDirection(command, direction);
            }
        }
        if (direction.equals("N")) {
            return new int[] { offsetX, offsetY };
        }
        return excute(commands, offsetX, offsetY, direction);
    }

    private String getDirection(String command, String direction) {
        if ("N".equals(direction)) {
            if (L.equals(command)) {
                direction = "W";
            }
            if (R.equals(command)) {
                direction = "E";
            }
            return direction;
        }
        if ("S".equals(direction)) {
            if (L.equals(command)) {
                direction = "E";
            }
            if (R.equals(command)) {
                direction = "W";
            }
            return direction;
        }
        if ("E".equals(direction)) {
            if (L.equals(command)) {
                direction = "N";
            }
            if (R.equals(command)) {
                direction = "S";
            }
            return direction;
        }
        if ("W".equals(direction)) {
            if (L.equals(command)) {
                direction = "S";
            }
            if (R.equals(command)) {
                direction = "N";
            }
            return direction;
        }
        return direction;
    }

}
