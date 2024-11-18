import java.util.*;

class Solution {
    private static List<File> list = new ArrayList<>();

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int idx = 0;
        for (String file : files) {
            boolean numflag = false;
            StringBuilder num = new StringBuilder();
            StringBuilder head = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                if (c >= '0' && c <= '9') {
                    num.append(c);
                    numflag = true;
                } else {
                    if (!numflag) head.append(c);
                    else {
                        tail.append(file.substring(i));
                        break;
                    }
                }
            }
            System.out.println(head + " " + num + " " + tail);
            list.add(new File(idx, head.toString(), num.toString(), tail.toString()));
            idx++;
        }

        Collections.sort(list);

        for (int i = 0; i < answer.length; i++) {
            File file = list.get(i);
            answer[i] = file.head + file.num + file.tail;
        }

        return answer;
    }

    private static class File implements Comparable<File> {
        int idx;
        String head;
        String num;
        String tail;

        public File(int idx, String head, String num, String tail) {
            this.idx = idx;
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        @Override
        public int compareTo(File f) {
            if (this.head.equalsIgnoreCase(f.head)) {
                if (Integer.parseInt(this.num) == Integer.parseInt(f.num)) {
                    return this.idx - f.idx;
                }
                return Integer.parseInt(this.num) - Integer.parseInt(f.num);
            }
            return this.head.toLowerCase().compareTo(f.head.toLowerCase());
        }
    }
}

/*
    head : 모두 소문자로 치환 -> head 순으로 정렬(단 동일한 경우 위치 안 바뀌게 해야 함 = 안정정렬)
    -> java 의 collections.sort 는 안정정렬이다.
    number : 숫자로 취급하여 비교
    
    1. 파일명을 head, number, tail로 나눈다.
    2. 기본적으로 head(모두 소문자 치환) 순으로 정렬하되,
       head 가 같으면 number 로 정렬하는 메서드 제작 활용.
*/
