<template>
    <div class="row">
        <Article v-for="article in articles" v-bind="article" v-bind:key="article.articleUrl"></Article>
    </div>
</template>

<script>
    import {fetchSomething} from "../api";
    import Article from "../article/Article";

    export default {
        name: 'ArticleRoot',
        components: {Article},
        data() {
            return {articles: []}
        },
        mounted() {
            fetchSomething()
                .then(res => {
                    this.articles = res.articles;
                });
        },
        props: {}
    }
</script>