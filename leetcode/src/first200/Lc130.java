package first200;

import org.junit.Test;

public class Lc130 {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0&&j!=0&&i!=m-1&&j!=n-1){
                    continue;
                }
                if(board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='@'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else continue;
            }
        }

    }
    public void dfs(char board[][],int x,int y){
        int m=board.length;
        int n=board[0].length;
        if(x<0||x>=m||y<0||y>=n){
            return ;
        }
        if(board[x][y]!='O'){
            return ;
        }
        board[x][y]='@';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }

    @Test
    public void test(){
        char board[][]=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(char c[]:board){
            for(char d:c){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
}
