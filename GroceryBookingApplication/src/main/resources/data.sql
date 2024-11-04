-- Insert sample users
INSERT INTO users (username, password, email) VALUES
('john_doe', 'password123', 'john@example.com'),
('jane_doe', 'password456', 'jane@example.com');

-- Insert sample grocery items
INSERT INTO grocery_items (name, price, description, inventory_level) VALUES
('Apple', 0.50, 'Fresh red apples', 100),
('Banana', 0.30, 'Ripe bananas', 150),
('Orange', 0.60, 'Juicy oranges', 80);

-- Insert sample orders
INSERT INTO orders (user_id) VALUES
(1),  -- Order for john_doe
(2);  -- Order for jane_doe

-- Insert sample order items
INSERT INTO order_items (order_id, grocery_item_id, quantity) VALUES
(1, 1, 3),  -- 3 Apples for order 1
(1, 2, 2),  -- 2 Bananas for order 1
(2, 3, 5);  -- 5 Oranges for order 2