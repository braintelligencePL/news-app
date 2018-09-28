const country = "pl";
// const category = "technology";

function fetchArticles(category) {
    return fetch(`http://localhost:8080/news/${country}/${category}`)
        .then(res => res.json())
        .then(article => (
            {
                ...article,
                articles: article.articles.map(res => ({
                    title: res.title || '',
                    author: res.author || '',
                    description: res.description || '',
                    date: res.date || '',
                    sourceName: res.sourceName || '',
                    articleUrl: res.articleUrl || '',
                    imageUrl: res.imageUrl || ''
                }))
            }));

}

export {
    fetchArticles
}
