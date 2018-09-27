const country = "pl";
const category = "technology";

function fetchArticles() {
    return fetch(`http://localhost:8080/news/${country}/${category}`)
        .then(res => res.json())
}

export {
    fetchArticles
}
