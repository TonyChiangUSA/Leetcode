package Pony;

import java.util.List;

public class Hanoi {
    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private void movePlate(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (num == 1) {    // 只剩一个盘子时，直接移动即可
            C.add(A.remove(A.size() - 1));
            return;
        }

        movePlate(num - 1, A, C, B);   // 将 size-1 个盘子，从 A 移动到 B
        C.add(A.remove(A.size() - 1));   // 将 A最底层的盘子，移动到C
        movePlate(num - 1, B, A, C);   // 将 B 的盘子，移动到 C
    }
}
