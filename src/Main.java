//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.*;

class robot{
    int pos, health,position;
    char direction;

    public robot(int i, int health, int position, char direction) {
        this.pos = i;
        this.health = health;
        this.position = position;
        this.direction = direction;
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "RRRR";
        int[] p = {1,2,3,4,5};
        int[] health = {10,15,20,25,20};
        List<Integer> res = survivedrobots(p,health,s);
        int i =0;
        while(i<res.size())
        {
            System.out.println(res.get(i));
            i++;
        }

        }
        public static List<Integer>  survivedrobots(int[] positions, int[] health, String directions){
        List<Integer>  res = new ArrayList<>();
        robot[] robots = new robot[positions.length];
            for (int i = 0; i < robots.length; i++) {
                robots[i] = new robot(positions[i], health[i], i, directions.charAt(i));
            }

            Arrays.sort(robots, Comparator.comparingInt(a->a.position));

            Stack<robot> stack = new Stack<>();


            for(int i = 0; i < robots.length; i++) {
                while (robots[i].direction == 'L' && !stack.isEmpty() && stack.peek().direction == 'R') {
                    robot prev = stack.pop();

                    if (robots[i].health == prev.health) {
                        robots[i].health = 0;
                        break;
                    } else if (robots[i].health > prev.health) {
                        robots[i].health -= 1;
                    } else {
                        robots[i].health = 0;
                        prev.health -= 1;
                        stack.push(prev);
                        break;
                    }
                }
                if (robots[i].health > 0) {
                    stack.push(new robot(robots[i].position, robots[i].health, robots[i].pos, robots[i].direction));
                }
            }

            robots = new robot[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                robots[i++] = stack.pop();
            }

            Arrays.sort(robots, Comparator.comparingInt(a -> a.pos));

            List<Integer> finalHealths = new ArrayList<>();

            for (robot robot : robots) {
                finalHealths.add(robot.health);
            }

            return finalHealths;
            }

}