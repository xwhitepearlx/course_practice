<?php
function addStudent($students, $name, $grades)
{
    $students[] = [
        "name" => $name,
        "grades" => $grades
    ];
    return $students;
}
function calculateAverage($grades)
{
    $sum = array_sum($grades);
    $count = count($grades);
    return $count > 0 ? $sum / $count : 0;
}
function getGradeLetter($average)
{
    if ($average >= 90) {
        $letter = "A";
    } elseif ($average >= 80) {
        $letter = "B";
    } elseif ($average >= 70) {
        $letter = "C";
    } elseif ($average >= 60) {
        $letter = "D";
    } else {
        $letter = "F";
    }
    return $letter;
}
function getTopStudent($students)
{
    $topStudent = null;
    $highestAverage = -1;
    foreach ($students as $student) {
        $average = calculateAverage($student["grades"]);
        if ($average > $highestAverage) {
            $highestAverage = $average;
            $topStudent = $student;
            $topStudent["average"] = $average;
            $topStudent["grade"] = getGradeLetter($average);
        }
    }
    return $topStudent;
}

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>
        Grade Manager
    </h1>
    <?php
    $students = [];
    $students = addStudent($students, "Dianna", [99, 56, 77]);
    $students = addStudent($students, "Rosanna", [79, 86, 77]);
    $students = addStudent($students, "Tinna", [89, 86, 99]);
    foreach ($students as $student) {
        $name = $student["name"];
        $grades = $student["grades"];
        $average = calculateAverage($grades);
        $grade = getGradeLetter($average);
        echo "<strong>Student:</strong> $name <br>";
        echo "<strong>Grades:</strong> " . implode(", ", $grades) . "<br>";
        echo "<strong>Average:</strong> " . number_format($average, 2) . "<br>";
        echo "<strong>Grade:</strong> $grade <br><br>";
    }
    $topStudent = getTopStudent($students);

    echo "<h2>Top Student</h2>";
    echo "<strong>Student:</strong>" . $topStudent["name"] . "<br>";
    echo "<strong>Grades:</strong> " . implode(", ", $topStudent["grades"]) . "<br>";
    echo "<strong>Average:</strong> " . number_format($topStudent["average"], 2) . "<br>";
    echo "<strong>Grade:</strong>" . $topStudent["grade"] . "<br><br>";
    ?>
</body>

</html>