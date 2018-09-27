<template>
    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img class="card-img-top"
                 data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail"
                 alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"
                 v-bind:src="imageUrl"
                 data-holder-rendered="true">
            <div class="card-body">
                <p class="card-text">{{description}}}</p>
                <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                        <a class="btn btn-sm btn-outline-secondary" v-bind:href="articleUrl">View</a>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Article',
        props: {
            title: String,
            author: String,
            description: String,
            date: String,
            sourceName: String,
            articleUrl: String,
            imageUrl: String
        }
    }
</script>