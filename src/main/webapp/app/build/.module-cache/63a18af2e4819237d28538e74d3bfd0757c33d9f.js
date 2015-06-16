'use strict';

var React = require('react');

var App = React.createClass({displayName: "App",
    render() {
        return React.createElement("h1", null, "Yo");
    }
});

React.renderComponent(React.createElement(App, null), document.body);