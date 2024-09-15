
    // Fetch the username from the backend API
    document.addEventListener("DOMContentLoaded", function() {
    fetch('/api/username')
        .then(response => response.json())
        .then(data => {
            var username = data.username;
            document.getElementById("username").textContent = username;
        })
        .catch(error => console.error('Error fetching username:', error));
});

    // Load all posts
    async function loadPosts() {
    try {
    const response = await fetch('/all');
    const posts = await response.json();
    const postsContainer = document.getElementById('postsContainer');

    postsContainer.innerHTML = '';

    posts.forEach(post => {
    // Create a post element
    const postElement = document.createElement('div');
    postElement.classList.add('post');
    postElement.innerHTML = `
                    <div class="postContent">
                        <p class="username">${post.username}</p> <!-- Username above post -->
                        <img src="data:image/jpeg;base64,${post.image}" alt="Post Image">
                        <p>${new Date(post.date).toLocaleDateString()}</p>
                        <p>${post.description}</p>
                    </div>
                    <div class="postComments">
                        <h4>Comments</h4>
                        ${post.comments.map(comment => `
                            <div class="comment">
                                <strong>${comment.username}</strong>: ${comment.text}
                            </div>
                        `).join('')}
                        <div  class="comment-input-container">
                            <input type="text" id="commentText-${post.id}" placeholder="Add a comment">
                            <button onclick="addComment(${post.id})">Submit</button>
                        </div>
                    </div>
                `;
    postsContainer.appendChild(postElement);
});
} catch (error) {
    console.error('Error:', error);
}
}

    // Add a comment
    async function addComment(postId) {
    const commentText = document.getElementById(`commentText-${postId}`).value;
    if (!commentText) {
    alert('Please enter a comment!');
    return;
}

    try {
    const response = await fetch(`/addComment`, {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify({ postId: postId, comment: commentText })
});

    if (response.ok) {
    alert('Comment added!');
    loadPosts(); // Reload posts to show the updated comments
} else {
    console.error('Failed to add comment');
}
} catch (error) {
    console.error('Error adding comment:', error);
}
}

    // Load posts on page load
    loadPosts();
