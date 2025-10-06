<?php
$inventory = [
    [
        "name" => "Laptop",
        "quantity" => 7,
        "price" => 999.9
    ],
    [
        "name" => "Keyboard",
        "quantity" => 9,
        "price" => 299.9
    ],
    [
        "name" => "Mouse",
        "quantity" => 7,
        "price" => 129.9
    ],
    [
        "name" => "Type-C Cable",
        "quantity" => 27,
        "price" => 49.9
    ],
    [
        "name" => "USB drive",
        "quantity" => 13,
        "price" => 119.9
    ]
];

function addItem($inventory, $item)
{
    $inventory[] =  $item;
    return $inventory;
}

function updateQuantity($inventory, $itemName, $newQuantity)
{
    for ($i = 0; $i < count($inventory); $i++) {
        if ($inventory[$i]["name"] === $itemName) {
            $inventory[$i]["quantity"] = $newQuantity;
        }
    }
    return $inventory;
}

function displayInventory($inventory)
{
    foreach ($inventory as $item) {
        foreach ($item as $key => $value) {
            echo "<strong>" . ucfirst($key) . ": </strong>$value<br>";
        }
        echo "<br>";
    }
}

function getTotalValue($inventory)
{
    $totalPrice = 0;
    foreach ($inventory as $item) {
        $quantity = $item["quantity"];
        $price = $item["price"];
        $subtotalPrice = $quantity * $price;
        $totalPrice += $subtotalPrice;
    }
    return $totalPrice;
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
    <h1>Inventory Manager</h1>
    <?php
    echo "<h2>Display Inventory</h2><br>";
    displayInventory($inventory);

    echo "<h2>Display Inventory after add a item</h2><br>";
    $newItem = [
        "name" => "Tablet",
        "quantity" => 5,
        "price" => 499.9
    ];
    $inventory = addItem($inventory, $newItem);
    displayInventory($inventory);

    echo "<h2>Display Inventory after updating item quantity</h2><br>";
    $inventory = updateQuantity($inventory, "Laptop", 12);
    displayInventory($inventory);

    echo "<br>";
    echo "Total inventory value: $" . number_format(getTotalValue($inventory), 2);
    echo "<br>";

    echo "<br>";
    $lowStock = array_filter($inventory, function ($item) {
        return $item["quantity"] < 10;
    });
    echo "Item low on stock: <br>";
    foreach ($lowStock as $item) {
        echo "- " . $item["name"] . "<br>";
    }

    echo "<h2>Display Inventory after discount</h2><br>";
    $discountedInventory = array_map(function($item){
        $item["price"] = $item["price"] *0.9;
        return $item;
    },$inventory);
    displayInventory($discountedInventory);
    ?>
</body>

</html>