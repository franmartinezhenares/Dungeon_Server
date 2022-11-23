let room = new Object();
room = JSON.parse(document.getElementById("currentRoom").textContent);

const srcs = ["/assets/game_background.jpg", "/assets/player_spritesheet.png", "/assets/key_image.png", "/assets/wall_image.png", "/assets/wall_image_2.png",
"/assets/door_image.png", "/assets/door_image_2.png", "/assets/coin_image.png"];
const images = srcs.map((src) => {
    const image = new Image();
    image.src = src;
    return image;
});
const imagesLoaded = () => images.every((image) => image.complete);
images.forEach((image) => {
    image.onload = () => {
        if (imagesLoaded()) {
            drawUI();
            ctx.drawImage(images[1], 48, 0, 48, 72, 438, 138, 48,72);
        }
    };
});


let canvas = document.getElementById("navigation_canvas");
const ctx = canvas.getContext("2d");
let scale = 2;

canvas.addEventListener("mousedown", function (event) {
    clickHandler();
});

const spriteWidth = 48;
const spriteHeight = 72;
let frameX = 0;
let frameY = 0;
let destinationX = 438;
let destinationY = 138;


let start, previousTimeStamp;
let done = false;
let frameCount = 0;

function moveN(timestamp) {

    frameY = 3;
    frameCount++;

    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.2 * elapsed, 200);
        destinationY--;
        if(frameCount > 5){
            frameX++
            if(frameX > 2){
                frameX = 0;
            }
            frameCount = 0;
        }
        drawUI();
        ctx.drawImage(images[1], frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
            destinationX, destinationY, spriteWidth,spriteHeight);
        if (count > 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveN);
        } else {
            window.location.assign("/nav?dir=NORTH")
        }
    }
}
function moveS(timestamp) {

    frameY = 0;
    frameCount++;

    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.2 * elapsed, 200);
        destinationY++;
        if(frameCount > 5){
            frameX++
            if(frameX > 2){
                frameX = 0;
            }
            frameCount = 0;
        }
        drawUI();
        ctx.drawImage(images[1], frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
            destinationX, destinationY, spriteWidth,spriteHeight);
        if (count > 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveS);
        }else{
            window.location.assign("/nav?dir=SOUTH")
        }
    }
}
function moveW(timestamp) {

    frameY = 1;
    frameCount++;

    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.2 * elapsed, 200);
        destinationX--;
        if(frameCount > 5){
            frameX++
            if(frameX > 2){
                frameX = 0;
            }
            frameCount = 0;
        }
        drawUI();
        ctx.drawImage(images[1], frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
            destinationX, destinationY, spriteWidth,spriteHeight);
        if (count > 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveW);
        } else {
            window.location.assign("/nav?dir=WEST")
        }
    }
}
function moveE(timestamp) {

    frameY = 2;
    frameCount++;

    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.2 * elapsed, 200);
        destinationX++;
        if(frameCount > 5){
            frameX++
            if(frameX > 2){
                frameX = 0;
            }
            frameCount = 0;
        }
        drawUI();
        ctx.drawImage(images[1], frameX*spriteWidth, frameY*spriteHeight, spriteWidth, spriteHeight,
            destinationX, destinationY, spriteWidth,spriteHeight);
        if (count > 150) done = true;
    }

    if (elapsed < 2000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveE);
        } else {
            window.location.assign("/nav?dir=EAST");
        }
    }
}

function drawUI() {
    ctx.drawImage(images[0], 0, 0);
    drawRoom(room);
    drawInventory(room.player.playerCoins, room.player.playerKeys, room.walls.RoomID);
    drawMessage(room.walls.Message);
}

function drawInventory(coins, keys, roomID) {
    ctx.font = "36px Castelar";
    ctx.fillStyle = "#ddd";
    ctx.fillText("" + coins, 178, 52);
    ctx.font = "26px Castelar";
    ctx.fillText("" + roomID, 160, 229);

    keys.forEach(element => {
        if(element==="bronzeKey") {
            ctx.drawImage(images[2], 40, 140);
        }
        if(element==="silverKey") {
            ctx.drawImage(images[2], 120, 140);
        }
        if(element==="goldKey") {
            ctx.drawImage(images[2], 200, 140);
        }
    });
}

function drawMessage(message) {
    ctx.font = "16px Castelar";
    ctx.fillStyle = "#ddd";
    ctx.fillText(message, 20, 285);
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

        // Restart
        if(posX > 82 && posX < 196 && posY > 325 && posY < 355) {
            restart();
        }
    }
}

function navigateDungeon(direction) {
    let moveTo = direction;

    switch (moveTo) {
        case "up":
            requestAnimationFrame(moveN);
            break;
        case "down":
            requestAnimationFrame(moveS);
            break;
        case "left":
            requestAnimationFrame(moveW);
            break;
        case "right":
            requestAnimationFrame(moveE);
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
            window.location.assign("/open?dir=NORTH")
            break;
        case "down":
            window.location.assign("/open?dir=SOUTH")
            break;
        case "left":
            window.location.assign("/open?dir=WEST")
            break;
        case "right":
            window.location.assign("/open?dir=EAST")
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function getKey() {
    if(room.item.Key === "bronzeKey" || room.item.Key === "silverKey" || room.item.Key === "goldKey") {
        window.location.assign("/getkey");
    }
}

function getCoin() {
    if(room.item.Coin === "Coin") {
        window.location.assign("/getcoin");
    }
}

function restart() {

}

function drawWall(position) {

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            ctx.drawImage(images[4], 420, 73);
            break;
        case "down":
            ctx.drawImage(images[4], 420, 273);
            break;
        case "left":
            ctx.drawImage(images[3], 353, 140);
            break;
        case "right":
            ctx.drawImage(images[3], 553, 140);
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }
}

function drawDoor(position) {

    let drawPosition = position;

    switch (drawPosition) {
        case "up":
            ctx.drawImage(images[6], 420, 62);
            break;
        case "down":
            ctx.drawImage(images[6], 420, 262);
            break;
        case "left":
            ctx.drawImage(images[5], 342, 140);
            break;
        case "right":
            ctx.drawImage(images[5], 542, 140);
            break;
        default:
            console.log("NOT A DIRECTION")
            break;
    }

}

function drawCoin() {
    ctx.drawImage(images[7], 500, 100);
}

function drawKey() {
    ctx.drawImage(images[2], 380, 100);
}

function drawRoom(room) {

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
drawUI();