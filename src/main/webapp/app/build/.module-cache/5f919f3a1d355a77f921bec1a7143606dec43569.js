/**
 * Created by chris on 6/8/15.
 */
var pokerhand = React.createClass(
    {
        displayName: 'Poker Hand',
        render: function() {
            return (
                React.createElement('div', {className: "pokerhand"},
                    "Hello this is a poker hand"
                )
            )
        }
    }
)