package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 과제 진행하기
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176962">과제 진행하기</a>
 */
public class WorkAssignment {


    public String[] solution(String[][] plans) {
        List<String> answerList = new ArrayList<>();
        List<Plans> plansList = Arrays.stream(plans).map(Plans::new).collect(Collectors.toList());

        Stack<Plans> plansStack = new Stack<>();

        List<Plans> sortedPlanList = plansList.stream().sorted(Plans::compareTo).collect(Collectors.toList());


        int nowTime = sortedPlanList.get(0).startMinutes;
        int futureTime = sortedPlanList.get(1).startMinutes;

        for (int idx = 0; idx < sortedPlanList.size() - 1; idx++) {
            Plans nowPlan = sortedPlanList.get(idx);
            Plans afterPlan = sortedPlanList.get(idx + 1);

            if (nowTime + nowPlan.getPlayTime() > futureTime) {
                nowPlan.changeRemainPlayTime(afterPlan.getStartMinutes() - nowTime);
                plansStack.push(nowPlan);

                nowTime = futureTime;
            } else {
                answerList.add(nowPlan.getSubject());
                nowTime += nowPlan.getPlayTime();

                boolean finish = false;

                while(!finish) {
                    if (nowTime < futureTime) {
                        if (plansStack.isEmpty()) {
                            nowTime = afterPlan.getStartMinutes();
                            finish = true;
                        } else {
                            Plans stackPlan = plansStack.pop();

                            if (nowTime + stackPlan.getPlayTime() > futureTime) {

                                stackPlan.changeRemainPlayTime(futureTime - nowTime);
                                plansStack.push(stackPlan);

                                nowTime = futureTime;

                            } else {
                                answerList.add(stackPlan.getSubject());
                                nowTime += stackPlan.getPlayTime();
                            }
                        }
                    } else {
                        finish = true;
                    }
                }
            }

            if (idx != sortedPlanList.size() - 2) {
                futureTime = sortedPlanList.get(idx + 2).getStartMinutes();
            } else {
                plansStack.push(sortedPlanList.get(sortedPlanList.size() - 1));
            }

        }

        while (!plansStack.isEmpty()) {
            answerList.add(plansStack.pop().getSubject());
        }


        return answerList.toArray(new String[0]);
    }

    private static class Plans implements Comparable<Plans> {
        private final String subject;
        private final AssignmentTime startTime;
        private final int startMinutes;
        private int playTime;

        public Plans(String[] plans) {
            this.subject = plans[0];
            this.startTime = new AssignmentTime(Integer.parseInt(plans[1].substring(0, 2)), Integer.parseInt(plans[1].substring(3, 5)));
            this.startMinutes = this.startTime.getHour() * 60 + this.startTime.getMinutes();
            this.playTime = Integer.parseInt(plans[2]);
        }

        @Override
        public int compareTo(Plans o) {
            if (this.startTime.hour != o.startTime.hour) {
                return this.startTime.getHour() - o.startTime.getHour();
            }

            return this.startTime.getMinutes() - o.startTime.getMinutes();
        }

        public String getSubject() {
            return subject;
        }

        public int getStartMinutes() {
            return startMinutes;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void changeRemainPlayTime(int diffTime) {
            this.playTime -= diffTime;
        }

        private static final class AssignmentTime {
            private final int hour;
            private final int minutes;

            private AssignmentTime(int hour, int minutes) {
                this.hour = hour;
                this.minutes = minutes;
            }

            public int getHour() {
                return hour;
            }

            public int getMinutes() {
                return minutes;
            }
        }
    }
}
