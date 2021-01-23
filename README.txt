Klassen Pos2D lagrar rad och kolumn position och tillgängliggör getter, toString och parseInt funktioner.

Cell klassen är subklass till JButton och lagrar all relevant information för den cellen i spelet. Så som
om cellen är correct, dess position med hjälp av Pos2D och dess värde. Den har även setters, getters och en
checkCorrect metod som kontrollerar ifall cellens värde stämmer med dess position.

GameWindow klassen hanterar spelfönstret och dess logik. Den är subklass till JFrame och i dess konstruktör
skapar den ett fönster. Den kallar även generateCells metoden för att skapa alla celler. Metoden handelClick
innehåller spellogiken och är handler för cellernas ActionEvent. Första if satsen i handelClick kontrollerar ifall
den klickade cellen är ortogonalt kopplad till den tomma cellen.

