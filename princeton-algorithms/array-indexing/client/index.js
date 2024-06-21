import { makeRequest} from "./common/api.js";
const onPageLoad = (event) => {
    const btn = document.getElementById('button-1');
    btn.addEventListener('click', (event)=>window.alert("Clicked!!"));
    onIncrement();
}

const onIncrement = () => {
    const btn = document.getElementById('button-2');
    btn.addEventListener('click', updateCount);
}

const updateCount = () => {
    makeRequest("http://localhost:8080/get-count", 'GET', {},onSuccess, onError)
}

const onSuccess = (data) => {
    const countContainer = document.getElementById('count-container');
    countContainer.innerHTML = data;
}

const onError = () => {
    window.alert("Request failed!");
}

document.addEventListener('DOMContentLoaded', onPageLoad);
