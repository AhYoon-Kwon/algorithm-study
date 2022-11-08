//정확도 통과, 효율성 

import java.util.*;
class Solution {
    public static class Node{
        int cur;
        Node pre=null;
        Node post=null;
        public Node(Node pre, int cur){
            this.pre = pre;
            this.cur=cur;
        }
        
        public Node(int cur) {
            this.cur = cur;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        
        //연결관계 정보를 가진 Node로 리스트 생성
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(0));
        for(int i=1; i<n; i++){
            list.add(new Node(list.get(i-1), i));
        }
        for(int i=0; i<n-1; i++){
            list.get(i).post = list.get(i+1);
        }
        
        Stack<Node> stack  = new Stack<>();
        int num;
        //시작 노드(행)
        Node node = list.get(k);
        //명령어 배열 확인
        for(int i=0; i<cmd.length; i++){           
            StringTokenizer st = new StringTokenizer(cmd[i]);
            switch(st.nextToken()){
                case "U": 
                    num = Integer.parseInt(st.nextToken());
                    //현재 선택된 node -> num 만큼 이동
                    for(int x=0; x<num; x++){
                        node = list.get(node.cur).pre;
                    }
                    break;
                case "D": 
                    num = Integer.parseInt(st.nextToken());
                    //현재 선택된 node -> num 만큼 이동
                    for(int x=0; x<num; x++){
                        node = list.get(node.cur).post;
                    }
                    break;
                case "C":
                    stack.push(node);
                    if(node.post==null){ //현재 선택된 노드가 마지막 행이라면
                        Node pre = list.get(node.cur).pre;
                        //연결관계 업데이트
                        pre.post = null; 
                        //삭제 시 이전 행 선택
                        node=pre;
                    }else if(node.pre==null){//현재 선택된 노드가 첫 행이라면
                        Node post = list.get(node.cur).post;
                        //연결관계 업데이트
                        post.pre = null;
                        //삭제 시 다음행이 선택됨
                        node=post;
                    }else{ 
                        Node pre = list.get(node.cur).pre;
                        Node post = list.get(node.cur).post;
                        //연결관계 업데이트
                        pre.post = post; 
                        post.pre = pre;
                        //삭제 시 다음행이 선택됨
                        node=post;
                    }
                    break; 
                case "Z"://되살리기
                    Node restore = stack.pop();   
                    if(restore.post==null){ //삭제됐던게 마지막 행이라면
                        Node pre = list.get(restore.cur).pre;
                        //연결관계 업데이트
                        pre.post = restore;
                    }else if(restore.pre==null){ //첫행이라면
                        Node post = list.get(restore.cur).post;
                        //연결관계 업데이트
                        post.pre = restore; 
                    }else{ 
                        Node pre = list.get(restore.cur).pre;
                        Node post = list.get(restore.cur).post;
                        //연결관계 업데이트
                        pre.post = restore;
                        post.pre = restore; 
                    }  
                    break;
            }    
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append('O');
        }
        while(!stack.isEmpty()){
            Node delete = stack.pop();
            sb.setCharAt(delete.cur, 'X');
        }
        return sb.toString();
    }
}
