/**
 * Created by chris on 6/8/15.
 */
var Pokerhand = React.createClass(
    {
        displayName: 'Pokerhand',
        render: function() {
            return (
                React.createElement('div', {className: "pokerhand"},
                    "Hello this is a poker hand"
                )
            );
        }
    }
);