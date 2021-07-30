const d = document;
const $iD = id => d.getElementById(id);
const inicio = $iD("inicio");
const juego = $iD("juego"), playGame = $iD("btn-play-game"), activeBomb = $iD("btn-active-bomb"), newGame = $iD("btn-new-game");
const btnG = $iD("btn-green"), btnR = $iD("btn-red"), btnB = $iD("btn-blue");
const cont = $iD("cont");
const arrayBtns = [btnG, btnR, btnB];


let bombseconds = 30;
let minutes = 0;
let interval;
let arrayRandom = [];

let audioCountDown = new Audio("bombaatras.mp3");
let audioBombBom = new Audio("bombabom.mp3");
let audioStopBomb = new Audio("bombaparada.mp3");

juego.style.display = "none";

playGame.addEventListener('click', () => {
    let namePlayer = $iD("nombre-jugador").value;
    console.log(namePlayer);
    if (namePlayer.length == 0) {
        inicio.insertAdjacentHTML("afterbegin", `<h4> Debe de poner un nombre!! </h4>`)
        console.log("errorFaltaNombre"); return ""
    };
    saveLSPropertiesBySelector("namePlayer", "nombre-jugador");
    inicio.style.display = "none";
    showPlay();
});

activeBomb.addEventListener('click', () => {
    activeBomb.disabled = true;
    newGame.disabled = false;
    audioCountDown.play();
    countDown();
    interval = setInterval(countDown, 1000);
    // arrayRandom = startGame(stopBomb, bomBomb, speedTimeCountDown);
    startGame(stopBomb, bomBomb, speedTimeCountDown)
});

newGame.addEventListener('click', () => {
    cont.innerHTML = "00:00";
    removeInterval();
    audioCountDown.pause();
    bombseconds = 30;
    inicio.style.display = "block";
    juego.style.display = "none";
    activeBomb.disabled = false;
    newGame.disabled = true;
})
let btnred, btnblue, btngreen;

function startGame(...actions) {

    let random = Math.floor((Math.random() * actions.length));
    btnred = actions[random];
    actions.slice(actions[random]);
    random = Math.floor((Math.random() * actions.length));
    btnblue = actions[random];
    actions.slice(actions[random]);
    random = Math.floor((Math.random() * actions.length));
    btngreen = actions[0];
    actions.slice(actions[random]);

}

function asignarColorBtn(color) {
    if (color == 'blue') {
        btnblue();
        btnB.disabled = true;
    }
    else if (color == 'red') {
        btnred();
        btnR.disabled = true;
    } else if (color == 'green') {
        btngreen();
        btnG.disabled = true;
    }
}


/** LOCALSTORE LS */
function saveLSPropertiesBySelector(namePropertieLS, nameSelectorById) {
    // console.log({ namePropertieLS });
    let valuePropertieLS = $iD(nameSelectorById).value;
    localStorage.setItem(namePropertieLS, valuePropertieLS);
}

const getLSPropertiesByName = nameLS => localStorage.getItem(nameLS);

/** LOCALSTORE LS */


function showPlay() {
    juego.style.display = "block";
    let namePlayer = getLSPropertiesByName("namePlayer");
    $iD("mensajeJuego").innerHTML = namePlayer
}

function countDown() {
    cont.innerHTML = ("0" + minutes).slice(-2) + ":" + ("0" + bombseconds).slice(-2);
    bombseconds == 0 ? stopCountDown() : bombseconds--;
    if (bombseconds == 10) { speedTimeCountDown10s() }
}

const speedTimeCountDown10s = () => {
    removeInterval();
    audioCountDown.playbackRate = 1.5;
    interval = setInterval(countDown, 500)
}

const stopBomb = () => {
    removeInterval();
    audioCountDown.pause();
    audioStopBomb.play();
}

const bomBomb = () => {
    audioBombBom.play();

}

const speedTimeCountDown = () => {
    removeInterval();
    audioCountDown.playbackRate = 1.1;
    interval.setInterval(countDown, 750);
}

const removeInterval = () => { clearInterval(interval); }

// mostrar ranking ?
const saveDataRanking = (secondsBomb, player, statusBomb) => {
    let dataRanking = { 'secondsBomb': secondsBomb, 'player': player, 'statusBomb': statusBomb }
    localStorage.setItem("dataRanking", JSON.stringify(dataRanking));
    //Para recuperarlo
}

