public class Robot implements Runnable{
    private String name;
    private boolean running=true;
    Exploration explore;

    public Robot(String name)
    {
        this.name=name;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public Exploration getExplore() {
        return explore;
    }

    public String getName() {
        return name;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            for(int row=0;row<explore.getMap().getMatrix().length;row++)
            {
                for(int col=0; col<explore.getMap().getMatrix()[row].length;col++)
                {
                    if(!explore.getMap().getMatrix()[row][col].isVisited()) {
                        explore.getMap().visit(row, col, this);
                    }
                }
            }
            running = false;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}