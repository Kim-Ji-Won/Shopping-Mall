const cartTableBody = document.querySelector('#cart tbody');
const totalPriceEl = document.getElementById('total-price');
const clearCartBtn = document.getElementById('clear-cart');

let cart = JSON.parse(localStorage.getItem('cart')) || [];

function renderCart() {
    cartTableBody.innerHTML = '';
    let total = 0;

    for(let i = 0; i < cart.length; i++){
        const item = cart[i];

        const tr = document.createElement('tr');
        
        const tdName = document.createElement('td');
        tdName.textContent = item.name;
        
        const tdPrice = document.createElement('td');
        tdPrice.textContent = item.price.toLocaleString() + "원";
        
        tr.appendChild(tdName);
        tr.appendChild(tdPrice);
        cartTableBody.appendChild(tr);
        total += item.price;
    }

    totalPriceEl.textContent = `총 합계 : ${total.toLocaleString()}원`;
}

// 장바구니 비우기
clearCartBtn.addEventListener('click', function() {
    cart = [];
    localStorage.removeItem('cart');
    renderCart();
});

// 초기 렌더링
renderCart();