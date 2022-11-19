let room = new Object();
room = JSON.parse(document.getElementById("currentRoom").textContent);

let canvas = document.getElementById("navigation_canvas");
const ctx = canvas.getContext("2d");
let scale = 2;

const background = new Image();
background.src = "/assets/game_background.jpg"

canvas.addEventListener("mousedown", function (event) {
    clickHandler();
});

function drawUI() {
    background.onload = () => {
        ctx.drawImage(background, 0, 0);
        drawRoom(room);
        drawInventory(room.player.playerCoins, room.player.playerKeys);
        drawMessage(room.walls.Message);
    }
}

function drawInventory(coins, keys) {
    ctx.font = "36px Castellar";
    ctx.fillStyle = "#ddd";
    ctx.fillText("" + coins, 178, 52);

    keys.forEach(element => {
        if(element==="bronzeKey") {
            const key = new Image();
            key.src = "/assets/key_image.png"
            key.onload = () => {
            ctx.drawImage(key, 40, 140);
            };
        }
        if(element==="silverKey") {
            const key = new Image();
            key.src = "/assets/key_image.png"
            key.onload = () => {
            ctx.drawImage(key, 120, 140);
            };
        }
        if(element==="goldKey") {
            const key = new Image();
            key.src = "/assets/key_image.png"
            key.onload = () => {
            ctx.drawImage(key, 200, 140);
            };
        }
    });
}

function drawMessage(message) {
    ctx.font = "12px Castellar";
    ctx.fillStyle = "#ddd";
    ctx.fillText(message, 20, 280);
}

function clickHandler() {
    const boundingRect = canvas.getBoundingClientRect();
    const posX = (Math.floor(event.clientX - boundingRect.left))/scale;
    const posY = (Math.floor(event.clientY - boundingRect.top))/scale;
    // console.log(posX + " / " +posY);

    if(room.player.playerWinner) {
        window.location.assign("/endform");
    } else {

        // Navigation

        if(posX > 390 && posX < 530 && posY > 0 && posY < 40) {
            navigateDungeon("up");
        }
        if(posX > 390 && posX < 530 && posY > 320 && posY < 360) {
            navigateDungeon("down");
        }
        if(posX > 280 && posX < 320 && posY > 110 && posY < 250) {
            navigateDungeon("left");
        }
        if(posX > 600 && posX < 640 && posY > 110 && posY < 250) {
            navigateDungeon("right");
        }

        // Doors

        if(posX > 440 && posX < 480 && posY > 60 && posY < 100) {
            openDoor("up");
        }
        if(posX > 440 && posX < 480 && posY > 260 && posY < 300) {
            openDoor("down");
        }
        if(posX > 340 && posX < 380 && posY > 160 && posY < 200) {
            openDoor("left");
        }
        if(posX > 540 && posX < 580 && posY > 160 && posY < 200) {
            openDoor("right");
        }

        // Key

        if(posX > 380 && posX < 415 && posY > 100 && posY < 135) {
            getKey();
        }

        // Coin

        if(posX > 500 && posX < 535 && posY > 100 && posY < 135) {
            getCoin();
        }
    }
}

function navigateDungeon(direction) {
    let moveTo = direction;

    switch (moveTo) {
        case "up":
            console.log("Moving UP !!!")
            window.location.assign("/nav?dir=NORTH")
            break;
        case "down":
            console.log("Moving DOWN !!!")
            window.location.assign("/nav?dir=SOUTH")
            break;
        case "left":
            console.log("Moving LEFT !!!")
            window.location.assign("/nav?dir=WEST")
            break;
        case "right":
            console.log("Moving RIGHT !!!")
            window.location.assign("/nav?dir=EAST")
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function openDoor(direction) {
    let openDirection = direction;

    switch (openDirection) {
        case "up":
            console.log("Open UP Direction Door")
            window.location.assign("/open?dir=NORTH")
            break;
        case "down":
            console.log("Open DOWN Direction Door")
            window.location.assign("/open?dir=SOUTH")
            break;
        case "left":
            console.log("Open LEFT Direction Door")
            window.location.assign("/open?dir=WEST")
            break;
        case "right":
            console.log("Open RIGHT Direction Door")
            window.location.assign("/open?dir=EAST")
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function getKey() {
    console.log("get Key!");
    window.location.assign("/getkey")
}

function getCoin() {
    console.log("get Coin!");
    window.location.assign("/getcoin")
}

function drawWall(position) {

    const wallLR = new Image();
    wallLR.src = "/assets/wall_image.png"
    const wallUD = new Image();
    wallUD.src = "/assets/wall_image_2.png"

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            wallUD.onload = () => {
                ctx.drawImage(wallUD, 420, 73);
            };
            break;
        case "down":
            wallUD.onload = () => {
                ctx.drawImage(wallUD, 420, 273);
            };
            break;
        case "left":
            wallLR.onload = () => {
                ctx.drawImage(wallLR, 353, 140);
            };
            break;
        case "right":
            wallLR.onload = () => {
                ctx.drawImage(wallLR, 553, 140);
            };
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function drawDoor(position) {

    const doorLR = new Image();
    doorLR.src = "/assets/door_image.png"
    const doorUD = new Image();
    doorUD.src = "/assets/door_image_2.png"

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            doorUD.onload = () => {
                ctx.drawImage(doorUD, 420, 62);
            };
            break;
        case "down":
            doorUD.onload = () => {
                ctx.drawImage(doorUD, 420, 262);
            };
            break;
        case "left":
            doorLR.onload = () => {
                ctx.drawImage(doorLR, 342, 140);
            };
            break;
        case "right":
            doorLR.onload = () => {
                ctx.drawImage(doorLR, 542, 140);
            };
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }

}

function drawCoin() {
    const coin = new Image();
    coin.src = "/assets/coin_image.png"
    coin.onload = () => {
        ctx.drawImage(coin, 500, 100);
    };
}

function drawKey() {
    const key = new Image();
    key.src = "/assets/key_image.png"
    key.onload = () => {
        ctx.drawImage(key, 380, 100);
    };
}


const player = new Image();
player.src = "/assets/player_spritesheet.png";

const spriteWidth = 48;
const spriteHeight = 72;
let frameX = 0;
let frameY = 0;
let gameFrame = 0;
let destinationX = 438;
let destinationY = 138;

let destinationCounter = 1;


function animatePlayer() {
//   ctx.drawImage(player, frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
//                        destinationX, destinationY, spriteWidth,spriteHeight);

    if(gameFrame%100 === 0) {
        if(frameX < 2) frameX++;
        else frameX = 0;
    }

    if(destinationCounter%15 === 0) {
        destinationY++;
    }

    gameFrame++;
    // destinationCounter++;

    console.log(gameFrame);


    // ctx.clearRect(destinationX, destinationY, spriteWidth, spriteHeight);
    ctx.drawImage(player, frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
                        destinationX, destinationY, spriteWidth,spriteHeight);

  requestAnimationFrame(animatePlayer);


};


function drawRoom(room) {
    console.log("North:" + room.walls.N);
    console.log("South:" + room.walls.S);
    console.log("East:" + room.walls.E);
    console.log("West:" + room.walls.W);


    if(room.walls.N === "Wall") {
        drawWall("up");
    }
    if(room.walls.N === "Door") {
        drawDoor("up");
    }
    if(room.walls.S === "Wall") {
        drawWall("down");
    }
    if(room.walls.S === "Door") {
        drawDoor("down");
    }
    if(room.walls.E === "Wall") {
        drawWall("right");
    }
    if(room.walls.E === "Door") {
        drawDoor("right");
    }
    if(room.walls.W === "Wall") {
        drawWall("left");
    }
    if(room.walls.W === "Door") {
        drawDoor("left");
    }

    if(room.item.Key === "bronzeKey" || room.item.Key === "silverKey" || room.item.Key === "goldKey") {
        drawKey();
    }
    if(room.item.Coin === "Coin") {
        drawCoin();
    }


}

animatePlayer();

drawUI();

// setInterval(drawUI, 1000);