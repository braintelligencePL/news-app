<template>
    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <Article
                        v-for="article in articles"
                        v-bind="article"
                        v-bind:key="article.articleUrl">
                </Article>
            </div>
        </div>
    </div>
</template>

<script>
    import {fetchArticles} from "../api";
    import Article from "../article/Article";

    export default {
        name: 'ArticleRoot',
        components: {Article},
        data() {
            return {articles: []}
        },
        mounted() {
            fetchArticles()
                .then(res => {
                    this.articles = res.articles;
                });
        },
        props: {}
    }
</script>