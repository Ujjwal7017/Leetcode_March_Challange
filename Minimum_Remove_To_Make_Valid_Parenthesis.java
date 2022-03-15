class Solution {
    public String minRemoveToMakeValid(String s) {
         int open = 0;
            char ch[] = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '(') {
                    open++;
                } else if (ch[i] == ')') {
                    if (open == 0) {
                        ch[i] = '*';
                    } else {
                        open--;
                    }
                }
            }

            // while(!stack.isEmpty()) {
            //     ch[stack.pop()] = '*';
            // }

            for (int i = ch.length - 1; i >= 0; i--) {
                if (ch[i] == '(' && open > 0) {
                    ch[i] = '*';
                    open--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] != '*') {
                    sb.append(ch[i]);
                }
            }

            return sb.toString();
    }
}
