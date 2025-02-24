const API_URL = "http://localhost:8081/productos"; // Asegúrate de que esta URL sea correcta

// Función para cargar y mostrar los productos
async function loadProducts() {
    const response = await fetch(API_URL);
    const products = await response.json();
    const tbody = document.querySelector("#productTable tbody");
    tbody.innerHTML = ""; // Limpiar la tabla antes de cargar los productos

    products.forEach(product => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.category}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td class="actions">
                <button onclick="deleteProduct(${product.id})">Eliminar</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

// Función para agregar un producto
document.getElementById("productForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const product = {
        name: document.getElementById("name").value,
        category: document.getElementById("category").value,
        price: parseFloat(document.getElementById("price").value),
        quantity: parseInt(document.getElementById("quantity").value)
    };

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(product)
    });

    if (response.ok) {
        loadProducts(); // Recargar la lista de productos
        document.getElementById("productForm").reset(); // Limpiar el formulario
    }
});

// Función para eliminar un producto
async function deleteProduct(id) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    if (response.ok) {
        loadProducts(); // Recargar la lista de productos
    }
}

// Cargar los productos al iniciar la página
loadProducts();