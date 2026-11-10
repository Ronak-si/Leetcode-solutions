class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<n;i++)
        {
            bfs(board,0,i);
            bfs(board,m-1,i);
        }
        for(int i=0;i<m;i++)
        {
            bfs(board,i,0);
            bfs(board,i,n-1);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='#')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    void bfs(char board[][],int r,int c)
    {
        if(board[r][c]!='O')return;

        int m = board.length;
        int n = board[0].length;

        int directions[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r,c});
        board[r][c] = '#';
        while(!queue.isEmpty())
        {
            int cell[]=queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int direction[] : directions)
            {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol]=='O')
                {
                    board[newRow][newCol]='#';
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
    }
}