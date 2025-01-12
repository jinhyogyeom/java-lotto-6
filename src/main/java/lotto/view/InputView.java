package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getPrice() {
        System.out.println("구매할 금액을 입력해주세요");
        return Console.readLine();
    }

    public static String getWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        return Console.readLine();
    }
}
