package amazon;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] states = new int[]{1, 1, 1, 0, 1, 1, 1, 1};
        Solution solution = new Solution();
        List<Integer> result = solution.cellCompete(states, 2);
        System.out.println(result);
    }

    public List<Integer> cellCompete(int[] states, int days) {

        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(0));

        for (int i = 1; i <= states.length; i++) {
            Cell cell = new Cell(states[i - 1]);
            cells.get(i - 1).setRight(cell);
            cell.setLeft(cells.get(i - 1));
            cells.add(cell);
        }
        cells.add(new Cell(0));
        cells.get(8).setRight(cells.get(9));

        while (days > 0) {
            List<Cell> curr_cells = new ArrayList<>();
            curr_cells.add(new Cell(0));

            for (int i = 1; i < 9; i++) {
                System.out.println(i);
                int state = cells.get(i).getRight().getState() - cells.get(i).getLeft().getState();
                int curr_state = state == 0 ? 0 : 1;
                Cell cell = new Cell(curr_state);
                cell.setLeft(curr_cells.get(i - 1));
                curr_cells.get(i - 1).setRight(cell);
                curr_cells.add(cell);
            }
            curr_cells.add(new Cell(0));
            curr_cells.get(8).setRight(curr_cells.get(9));
            cells = curr_cells;
            days--;
        }

        List<Integer> result = new ArrayList<>();
        cells.forEach(cell -> {
            result.add(cell.getState());
        });
        result.remove(0);
        result.remove(8);
        return result;
    }

    class Cell {


        private int state;
        private Cell left;
        private Cell right;

        public Cell(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Cell getLeft() {
            return left;
        }

        public void setLeft(Cell left) {
            this.left = left;
        }

        public Cell getRight() {
            return right;
        }

        public void setRight(Cell right) {
            this.right = right;
        }
    }


}
