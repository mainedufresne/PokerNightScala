'use strict';

var App = React.createClass({displayName: "App",
    render() {
        return (
            React.createElement("div", null, 
                React.createElement("h1", null, "Yo"), 
                React.createElement(Pokerhand, null)
            )
        );
    }
});

React.render(React.createElement(App, null), document.getElementById('content'));