<template>
    <div id="app">
        <ArticleRoot></ArticleRoot>
    </div>
</template>

<script>
    import ArticleRoot from './components/articleRoot/ArticleRoot.vue'

    export default {
        name: 'app',
        components: {
            ArticleRoot
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
